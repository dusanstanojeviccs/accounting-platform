/*jshint node:true*/
/* global require, module */
var EmberApp = require('ember-cli/lib/broccoli/ember-app');

module.exports = function(defaults) {
  var app = new EmberApp(defaults, {});


  app.import("vendor/bootstrap.min.js");
  app.import("vendor/bootstrap-checkbox-radio-switch.js");
  app.import("vendor/chartist.min.js");
  app.import("vendor/bootstrap-notify.js");
  app.import("vendor/moment.js");
  app.import("vendor/ember-table-sort-comparator.js");
  app.import("vendor/bootstrap-datetimepicker.min.js");

  return app.toTree();
};
