import Ember from 'ember';

export default Ember.Route.extend({
	model() {
		return Ember.RSVP.hash({
			invoices: this.store.query("invoice", {}),
			accounts: this.store.query('account', {}),
			vendors: this.store.query('vendor', {}),
		});	
	}
});