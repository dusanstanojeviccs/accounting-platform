import Ember from 'ember';
import SortBy from 'ember-sort-table/mixins/sort-by-d';


export default Ember.Controller.extend(SortBy, {
	store: Ember.inject.service(),
	tableId: "billsList",
	dataForTable: Ember.computed("model.bills", function() { 
		return this.get("model.bills").toArray(); 
	}),

	notDeleted: Ember.computed("sortedData.@each.isDeleted", function() {
		return this.get("sortedData").filter(bill => !bill.get("isDeleted"));
	}),

	actions: {
		setupNewBill() {
			let bill = this.get("store").createRecord("bill");
			
			bill.setVendor(this.get("model.vendors").objectAt(0));

			this.get("sortedData").addObject(bill);

			this.set("bill", bill);
		},
		setBill(bill) {
			this.set("bill", bill);
		}
	}
});
