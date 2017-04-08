import Ember from 'ember';

export default Ember.Component.extend({
	actions: {
		setVendor(index) {
			this.get("invoice").setVendor(this.get("vendors").objectAt(index));
		},
		backAction() {
			this.get("invoice").rollbackAttributes();
			Ember.$(".modal").modal("hide");
			this.set("invoice", null);
		},
		successAction() {
			this.get("invoice").save().then(() => {
				this.get("notifications").success("Invoice saved successfully");
				this.$(".modal").modal("hide");
			});
		}	
	}
});
