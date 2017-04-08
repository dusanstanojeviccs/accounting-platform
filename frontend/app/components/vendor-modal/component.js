import Ember from 'ember';

export default Ember.Component.extend({
	actions: {
		backAction() {
			this.get("vendor").rollbackAttributes();
			this.set("vendor", null);
			Ember.$(".modal").modal("hide");
		},
		successAction() {
			this.get("vendor").save().then(() => {
				this.get("notifications").success("Vendor saved successfully");
				this.$(".modal").modal("hide");
			});
		}	
	}
});
