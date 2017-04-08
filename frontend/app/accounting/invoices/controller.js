import Ember from 'ember';
import SortBy from 'ember-sort-table/mixins/sort-by-d';


export default Ember.Controller.extend(SortBy, {
	tableId: "invoicesList",
	dataForTable: Ember.computed("model.invoices", function() { return this.get("model.invoices").toArray(); }),

	notDeleted: Ember.computed("sortedData.@each.isDeleted", function() {
		return this.get("sortedData").filter(o => !o.get("isDeleted"));
	}),

	actions: {
		setupNewInvoice() {
			let invoice = this.get("store").createRecord("invoice");
			
			invoice.setVendor(this.get("model.vendors").objectAt(0));

			this.get("sortedData").addObject(invoice);

			this.set("invoice", invoice);
		},
		setInvoice(invoice) {
			this.set("invoice", invoice);
		}
	}
});
