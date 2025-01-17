from transformers import GPT2LMHeadModel, GPT2Tokenizer
import torch

# GPT-2 Modeli ve Tokenizer'ı Yükle
tokenizer = GPT2Tokenizer.from_pretrained("gpt2")
model = GPT2LMHeadModel.from_pretrained("gpt2")

# Dosyadaki metni düzenle
def correct_text(text):
    inputs = tokenizer(text, return_tensors="pt")
    with torch.no_grad():
        outputs = model.generate(inputs["input_ids"], max_length=500)
    corrected_text = tokenizer.decode(outputs[0], skip_special_tokens=True)
    return corrected_text

if __name__ == "__main__":
    # Örnek metin
    sample_text = "Hello, I am a A.I model. Can you help me writting code?"
    corrected = correct_text(sample_text)
    print("Düzeltilmiş Metin: ", corrected)
