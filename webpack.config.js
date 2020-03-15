const webpack = require('webpack');
const path = require('path');
const PATH_SOURCE = path.join(__dirname, '/src/main/reactor/src');
const PATH_BUILD = path.join(__dirname, '/src/main/resources/frontend');

module.exports = {

  entry: PATH_SOURCE + '/index.js',

  output: {
    path: PATH_BUILD,
    filename: 'js/bundle.js',
  },

  module: {
    rules: [
      {
        test: /\.m?js$/,
        exclude: /node_modules/,
        use: [{
          loader: 'babel-loader',
          options: {
            presets: [
              "@babel/preset-env",
              "@babel/preset-react"
            ]
          }
        }]
      }, {
        test: /\.css$/i,
        use: ['style-loader', 'css-loader']
      }
    ]
  },

  resolve: {
    modules: [path.join(__dirname, 'src'), 'node_modules'],
    extensions: ['.js', '.jsx', '.css', '.scss', '.json'],
  },
};