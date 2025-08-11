from datasets import load_dataset
import os
import shutil

dataset = load_dataset("MALIBA-AI/bambara-speech-recognition-leaderboard", "eval")

audio_dir = "D:/data/audios"
os.makedirs(audio_dir, exist_ok=True)

for i, example in enumerate(dataset["eval"]):
    audio_path = example["audio"]["path"]
    shutil.copy(audio_path, os.path.join(audio_dir, f"audio_{i}.flac"))

print("Audios copiés dans", audio_dir)
