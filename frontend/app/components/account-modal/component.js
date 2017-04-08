import Ember from 'ember';

export default Ember.Component.extend({
	actions: {
		backAction() {
			this.get("account").rollbackAttributes();
			Ember.$(".modal").modal("hide");
		},
		successAction() {
			this.get("account").save().then(() => {
				this.get("notifications").success("Account saved successfully");
				this.$(".modal").modal("hide");
			});
		}	
	}
});
