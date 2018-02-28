const path = require('path');
const webpack = require('webpack');
const HtmlWebpackPlugin = require('html-webpack-plugin');
var ExtractTextPlugin = require("extract-text-webpack-plugin");
var CopyWebpackPlugin = require('copy-webpack-plugin');

const defaults = {
  entry: './app/index.jsx',
  output: {
    path: path.join(__dirname, './resources/dist'),
    filename: 'bundle.js',
  },
  module: {
    loaders: [
        {
      test: /\.jsx?$/,
      exclude: /(node_modules|bower_components|public)/,
      loader: "babel"
    }, {
      test: /\.json$/,
      loader: 'json-loader'
  },
  {
      test: /\.css$/,
      loader: ExtractTextPlugin.extract('style-loader', 'css-loader')
  },
  {
      test: /\.scss$/,
      include: /app/,
      loader: ExtractTextPlugin.extract('style-loader', ['css-loader', 'sass-loader'])
  },
  {
      test: /\.(eot|woff|ttf|woff2|svg|png)(\?v=\d+\.\d+\.\d+)?$/,
      loader: "file-loader"
  }
],
  },
  resolve: {
    modulesDirectories: ['node_modules'],
    root: path.resolve('./app'),
    extensions: ['', '.js', '.jsx'],
  },

  plugins: [
    new webpack.NoErrorsPlugin(),
    new webpack.ProvidePlugin({
      '$': 'jquery',
      'jQuery': 'jquery',
      'window.jQuery': 'jquery',
    }),
    new ExtractTextPlugin('main.css'),
    new CopyWebpackPlugin([
            {
                from: __dirname + '/node_modules/prismjs/prism.js',
                to: __dirname + '/resources/dist'
            }
            ,
            {
                from: __dirname + '/node_modules/prismjs/themes/prism.css',
                to: __dirname + '/resources/dist'
            },
            {
                from: __dirname + '/node_modules/loaders.css/loaders.min.css',
                to: __dirname + '/resources/dist'
            }
  ])
]
};

module.exports = defaults;
