# model.py
import tensorflow as tf
from tensorflow.keras.applications import MobileNetV2
from tensorflow.keras import layers, models

def create_model(input_shape=(224, 224, 3), num_classes=10):
    # MobileNetV2 modelini yüklüyoruz, önceden eğitilmiş ağırlıkları kullanıyoruz
    base_model = MobileNetV2(weights='imagenet', include_top=False, input_shape=input_shape)
    
    # Modelin üst kısmını serbest bırakıyoruz (eğitilmesi için)
    base_model.trainable = False

    # Yeni sınıflar için üst katmanlar ekliyoruz
    model = models.Sequential([
        base_model,
        layers.GlobalAveragePooling2D(),
        layers.Dense(1024, activation='relu'),
        layers.Dense(num_classes, activation='softmax')
    ])

    model.compile(optimizer=tf.keras.optimizers.Adam(), loss='categorical_crossentropy', metrics=['accuracy'])
    
    return model
