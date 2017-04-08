import Ember from 'ember';

export default Ember.Controller.extend({
	store: Ember.inject.service(),

	actions: {
		setupNewBillLine() {
			let line = this.get("store").createFragment("billline");

			this.get("model.bill.lines").addObject(line);

			this.set("line", line);
		}
	}
});
