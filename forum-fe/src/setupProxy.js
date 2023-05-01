const { createProxyMiddleware } = require('http-proxy-middleware');
module.exports = function (app) {
    app.use(
        createProxyMiddleware('/api1', {
          target: 'http://localhost:8081',
          changeOrigin: true,
          pathRewrite: {
            "^/api1": "",
          },
          headers: {
            Connection: "keep-alive"
          }
        })
      );
    app.use(
        createProxyMiddleware('/api2', {
          target: 'http://localhost:8082',
          changeOrigin: true,
          pathRewrite: {
            "^/api2": "",
          },
          headers: {
            Connection: "keep-alive"
          }
        })
      );
    app.use(
      createProxyMiddleware('/api3', {
        target: 'http://localhost:8083',
        changeOrigin: true,
        pathRewrite: {
          "^/api3": "",
        },
        headers: {
          Connection: "keep-alive"
        }
      })
    );
}