import Ember from 'ember';

export default Ember.Route.extend({
	model(params) {
		return Ember.RSVP.hash({
			bill: this.store.find("bill", params.id),
			accounts: this.store.query('account', {}),
			vendors: this.store.query('vendor', {}),
		});
	},
	actions: {
		onDelete() {
			this.transitionTo("accounting.bills");
		}
	}
});
