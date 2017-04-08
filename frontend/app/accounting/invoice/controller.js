import Ember from 'ember';

export default Ember.Controller.extend({
	store: Ember.inject.service(),

	actions: {
		setupNewInvoiceLine() {
			let line = this.get("store").createFragment("invoiceline");

			this.get("model.invoice.lines").addObject(line);

			this.set("line", line);
		}
	}
});
