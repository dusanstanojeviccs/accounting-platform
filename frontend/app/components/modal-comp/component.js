import Ember from 'ember';

export default Ember.Component.extend({
	actions: {
		backClick() {
			this.sendAction("backAction");
		},
		btnClick() {
			this.sendAction("successAction");
		}
	}
});
