module.exports = {
  "development": {
    options: {
      paths: ["assets/styles", "vendor/bootstrap"],
      syncImport: true
    },
    files: {
      'tmp/result/assets/styles/bootstrap.css': 'vendor/bootstrap/less/bootstrap.less',
      'tmp/result/assets/styles/app.css': 'app/styles/app.less'
    }
  },
  
  //TODO Need to include in the build pipeline
  production: {
    options: {
      paths: ["assets/styles", "vendor/bootstrap"],
      syncImport: true,
      cleancss: true
    },
    files: {
      'tmp/result/assets/styles/bootstrap.css': 'vendor/bootstrap/less/bootstrap.less',
      'tmp/result/assets/styles/app.css': 'app/styles/app.less'
    }
  }
};
