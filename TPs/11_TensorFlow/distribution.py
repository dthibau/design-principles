import tensorflow as tf
import os
import skimage
import numpy as np
# Import the `pyplot` module
import matplotlib.pyplot as plt



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

images, labels = load_data(train_data_directory)

# Print the `images` dimensions
print(str(np.array(images).ndim)+' : dimension du vecteur de caracteristique (images)')

# Print the number of `images`'s elements
print(str(np.array(images).size)+' : nombre d''images')

# Print the first instance of `images`
print(' Une image est une matrice de pixels :')
print(np.array(images)[0])

# Print the `labels` dimensions
print(str(np.array(labels).ndim)+ ' : dimension du vecteur d''etiquette (labels)')

# Print the number of `labels`'s elements
print(str(np.array(labels).size)+ ' nombre d''etiquette')

# Count the number of labels
print(str(len(set(labels)))+ ' ; nombre d''etiquettes differentes')

print(' Distribution des etiquettes dans les exemples d''apprentissage :')
# Make a histogram with 62 bins of the `labels` data
plt.hist(labels, 62)
# Show the plot
plt.show()