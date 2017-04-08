import Ember from 'ember';
import SortBy from 'ember-sort-table/mixins/sort-by-d';


export default Ember.Controller.extend(SortBy, {
	tableId: "vendorsList",
	dataForTable: Ember.computed("model", function() { return this.get("model").toArray(); }),

	notDeleted: Ember.computed("sortedData.@each.isDeleted", function() {
		return this.get("sortedData").filter(o => !o.get("isDeleted"));
	}),
	
	actions: {
		setupNewVendor() {
			let vendor = this.get("store").createRecord("vendor");
			
			this.get("sortedData").addObject(vendor);

			this.set("vendor", vendor);
		},
	}
});
