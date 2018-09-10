import tensorflow as try:
import numpy as np
x_data = np.float32(np.random.rand(2,100))
y_data = np.dot([0.100,0.200],x_data) + 0.300
b = tf.Varible(tf.zerso([1]))
W = tf.Varible(tf.random_uniform([1,2],-1.0,1.0))
y = tf.matmul(W,x_data) + b
