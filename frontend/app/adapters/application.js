 /*jshint unused:false*/

import DS from 'ember-data';
export default DS.RESTAdapter.extend({

	shouldReloadRecord: function(store, snapshot) {
		return true;
	},

	shouldReloadAll: function(store, snapshot) {
		return true;
	},

	shouldBackgroundReloadRecord: function(store, snapshot) {
		return true;
	},

	shouldBackgroundReloadAll: function(store, snapshot) {
		return true;
	}
});