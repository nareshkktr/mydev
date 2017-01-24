exports.config ={ 
  paths: {
    "public": 'public',
     watched: [
      'app',
      'assets',
      'styles',
      'vendor',
    ]
  },
  npm: {
    enabled: false
  },
  modules: {
    definition: false,
    wrapper: false
  },
  files: {
    javascripts: {
      joinTo: {
        'js/app.js': /^app/,
        'js/vendor.js': /^(vendor)/
      },
      order: {
        before: [
          'vendor/scripts/angular.min.js',
          'app/modules/app.js'
        ]
      }
    },
    stylesheets: {
      joinTo: {
        'css/app.css': /^app/,
        'css/vendor.css': /^vendor/
      },
      order: {
        before: [],
        after: []
      }
    }
  },
  plugins: {
    autoReload: {
      match: {
        stylesheets: ['*.css','*.html'],
        javascripts: ['*.js']
      }
    }
  }

}