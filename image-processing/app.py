from flask import Flask, request, jsonify
from rembg import remove
from PIL import Image
import io
import os
from dotenv import load_dotenv
import cloudinary
import cloudinary.uploader

# ===============================
# Load Environment Variables
# ===============================
load_dotenv()

CLOUD_NAME = os.getenv("CLOUDINARY_CLOUD_NAME")
API_KEY = os.getenv("CLOUDINARY_API_KEY")
API_SECRET = os.getenv("CLOUDINARY_API_SECRET")

if not CLOUD_NAME or not API_KEY or not API_SECRET:
    raise RuntimeError("Cloudinary environment variables are missing")

# ===============================
# Flask App
# ===============================
app = Flask(__name__)

# ===============================
# Cloudinary Configuration
# ===============================
cloudinary.config(
    cloud_name=CLOUD_NAME,
    api_key=API_KEY,
    api_secret=API_SECRET,
    secure=True
)

# ===============================
# Image Processing
# ===============================
def remove_bg_and_add_background(image_bytes, bg_color=(245, 245, 245)):
    """
    Removes background and adds solid background color
    Best for clothes visibility
    """

    # Remove background (transparent output)
    removed_bg = remove(image_bytes)

    # Load transparent image
    img = Image.open(io.BytesIO(removed_bg)).convert("RGBA")

    # Solid background
    background = Image.new("RGBA", img.size, bg_color + (255,))

    # Merge
    final_image = Image.alpha_composite(background, img).convert("RGB")

    # Save to memory
    buffer = io.BytesIO()
    final_image.save(buffer, format="JPEG", quality=95)
    buffer.seek(0)

    return buffer


# ===============================
# API Endpoint
# ===============================
@app.route("/process-image", methods=["POST"])
def process_image():

    if "file" not in request.files:
        return jsonify({"error": "No file provided"}), 400

    file = request.files["file"]

    try:
        image_bytes = file.read()

        processed_image = remove_bg_and_add_background(
            image_bytes,
            bg_color=(245, 245, 245)  # light gray (best for clothes)
        )

        upload_result = cloudinary.uploader.upload(
            processed_image,
            folder="laundry-items",
            resource_type="image",
            format="jpg"
        )

        return jsonify({
            "imageUrl": upload_result["secure_url"]
        }), 200

    except Exception as e:
        return jsonify({"error": str(e)}), 500


# ===============================
# Run Server
# ===============================
if __name__ == "__main__":
    app.run(host="127.0.0.1", port=5001, debug=True)
