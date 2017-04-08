import Ember from 'ember';

export default Ember.Component.extend({
	actions: {
		backAction() {
			this.get("model").rollbackAttributes();
			Ember.$(".modal").modal("hide");
		},
		successAction() {

			this.get("model").destroyRecord().then(() => {
				this.get("notifications").success(this.get("type") + " deleted successfully");
				
				this.$(".modal").on("hidden.bs.modal", (e) => {
					if (this.get("onDelete")) {
						this.sendAction("onDelete");
					}
					$(e.currentTarget).unbind("hidden.bs.modal");
				}).modal("hide");
			});
		}	
	}
});
