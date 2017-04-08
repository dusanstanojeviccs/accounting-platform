import Ember from 'ember';

export default Ember.Route.extend({
	model() {
		return Ember.RSVP.hash({
			bills: this.store.query("bill", {}),
			accounts: this.store.query('account', {}),
			vendors: this.store.query('vendor', {}),
		});
	}
});
