import Ember from 'ember';

export default Ember.Route.extend({
	model(params) {
		return Ember.RSVP.hash({
			invoice: this.store.find("invoice", params.id),
			accounts: this.store.query('account', {}),
			vendors: this.store.query('vendor', {}),
		});
	},
	actions: {
		onDelete() {
			this.transitionTo("accounting.invoices");
		}
	}
});
