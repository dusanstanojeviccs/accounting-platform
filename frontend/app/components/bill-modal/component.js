import Ember from 'ember';

export default Ember.Component.extend({
	actions: {
		setVendor(index) {
			this.get("bill").setVendor(this.get("vendors").objectAt(index));
		},
		backAction() {
			this.get("bill").rollbackAttributes();
			this.set("bill", null);
			Ember.$(".modal").modal("hide");
		},
		successAction() {
			this.get("bill").save().then(() => {
				this.get("notifications").success("Bill saved successfully");
				this.$(".modal").modal("hide");
			});
		}	
	}
});
