import Ember from 'ember';

export default Ember.Component.extend({
	actions: {
		triggerModal() {
			Ember.$("#" + this.get("modalId")).modal({backdrop:'static', keyboard:false});

			if (this.get("onTrigger")) {
				this.sendAction("onTrigger");
			}
		}
	}
});
