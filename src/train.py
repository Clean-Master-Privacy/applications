# train.py
import numpy as np
import tensorflow as tf
from tensorflow.keras.preprocessing.image import ImageDataGenerator
from tensorflow.keras.datasets import cifar10
from model import create_model

# Veri setini yükleyelim (CIFAR-10 örneği)
(X_train, y_train), (X_test, y_test) = cifar10.load_data()

# Veriyi uygun şekilde yeniden şekillendiriyoruz
X_train = tf.image.resize(X_train, (224, 224))
X_test = tf.image.resize(X_test, (224, 224))

# Veriyi normalize ediyoruz
X_train, X_test = X_train / 255.0, X_test / 255.0

# Etiketleri one-hot encoding formatına çeviriyoruz
y_train = tf.keras.utils.to_categorical(y_train, 10)
y_test = tf.keras.utils.to_categorical(y_test, 10)

# Transfer öğrenme modelini oluştur
model = create_model(input_shape=(224, 224, 3), num_classes=10)

# Modeli eğitiyoruz (ilk aşama: transfer öğrenme)
model.fit(X_train, y_train, epochs=5, batch_size=32, validation_data=(X_test, y_test))

# Transfer öğrenme sonrası modelin üst katmanlarını serbest bırakıyoruz (sürekli öğrenme)
model.trainable = True
for layer in model.layers[:100]:  # Önceden eğitimli katmanları donmuş tutuyoruz
    layer.trainable = False

# Yeni veri ile modelin eğitimini sürdürüyoruz (sürekli öğrenme)
model.fit(X_train, y_train, epochs=5, batch_size=32, validation_data=(X_test, y_test))

# Modeli kaydediyoruz
model.save('continual_learning_model.h5')
