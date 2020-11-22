import tensorflow as tf
from tensorflow import keras

import os
import skimage
import numpy as np
# Import the `pyplot` module
import matplotlib.pyplot as plt

from skimage import transform 
from skimage.color import rgb2gray

import random



def load_data(data_directory):
    directories = [d for d in os.listdir(data_directory) 
                   if os.path.isdir(os.path.join(data_directory, d))]
    labels = []
    images = []
    for d in directories:
        label_directory = os.path.join(data_directory, d)
        file_names = [os.path.join(label_directory, f) 
                      for f in os.listdir(label_directory) 
                      if f.endswith(".ppm")]
        for f in file_names:
            images.append(skimage.data.imread(f))
            labels.append(int(d))
    return images, labels

ROOT_PATH = "/home/dthibau/Formations/DesignPrinciples/MyWork/TensorFlow/"
train_data_directory = os.path.join(ROOT_PATH, "Training")
test_data_directory = os.path.join(ROOT_PATH, "Testing")

images, labels = load_data(train_data_directory)

test_images, test_labels = load_data(test_data_directory)

# Rescale the images in the `images` array
images28 = [transform.resize(image, (28, 28)) for image in images]
# Convert `images28` to an array
images28 = np.array(images28)
# Convert `images28` to grayscale
images28 = rgb2gray(images28)

# Rescale the images in the `images` array
test_images28 = [transform.resize(test_image, (28, 28)) for test_image in test_images]
# Convert `images28` to an array
test_images28 = np.array(test_images28)
# Convert `images28` to grayscale
test_images28 = rgb2gray(test_images28)

# Construire le modele :
# 2 couches 
model = keras.Sequential([
    keras.layers.Flatten(input_shape=(28, 28)),
    keras.layers.Dense(128, activation=tf.nn.relu),
    keras.layers.Dense(62, activation=tf.nn.softmax)
])

# Compilation du modele :
model.compile(optimizer='adam',
              loss='sparse_categorical_crossentropy',
              metrics=['accuracy'])

# Apprentissage
model.fit(images28, labels, epochs=5)

# Evaluation sur l'ensemble de validation 
test_loss, test_acc = model.evaluate(test_images28, test_labels)

print('Test accuracy:', test_acc)
print('Test Loss:', test_loss)

predictions = model.predict(test_images28)

print(predictions[0])



# Plot test result sur 25 exemples
def plot_image(i, predictions_array, true_label, img):
  predictions_array, true_label, img = predictions_array[i], true_label[i], img[i]
  plt.grid(False)
  plt.xticks([])
  plt.yticks([])
  
  plt.imshow(img, cmap=plt.cm.binary)
  
  predicted_label = np.argmax(predictions_array)
  if predicted_label == true_label:
    color = 'blue'
  else:
    color = 'red'
  
  plt.xlabel("{} {:2.0f}% ({})".format(predicted_label,
                                100*np.max(predictions_array),
                                true_label),
                                color=color)

def plot_value_array(i, predictions_array, true_label):
  predictions_array, true_label = predictions_array[i], true_label[i]
  plt.grid(False)
  plt.xticks([])
  plt.yticks([])
  thisplot = plt.bar(range(62), predictions_array, color="#777777")
  plt.ylim([0, 1])
  predicted_label = np.argmax(predictions_array)
  
  thisplot[predicted_label].set_color('red')
  thisplot[true_label].set_color('blue')


# Plot the first X test images, their predicted label, and the true label
# Color correct predictions in blue, incorrect predictions in red
num_rows = 5
num_cols = 3
num_images = num_rows*num_cols
plt.figure(figsize=(2*2*num_cols, 2*num_rows))
offset = random.randint(1,1001)
for i in range(num_images):
  index=(offset+i)%np.array(test_images).size
  print(index)
  plt.subplot(num_rows, 2*num_cols, 2*i+1)
  plot_image(index, predictions, test_labels, test_images28)
  plt.subplot(num_rows, 2*num_cols, 2*i+2)
  plot_value_array(index, predictions, test_labels)
plt.show()
