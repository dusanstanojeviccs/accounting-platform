/* global ga */

import Ember from 'ember';
import ENV from 'frontend/config/environment';

export default Ember.Route.extend({
	auth: Ember.inject.service(),
	
	beforeModel() {
		Ember.$.ajaxSetup({
			dataType: 'json',
			contentType : 'application/json; charset=utf-8',
			cache: false,
			error: (error) => {
				
				if (error && error.status === 403) {
					return;	
				}
			}
		});

		Ember.setupAjaxGlobalSettings = function () {
			Ember.$.ajaxSetup({
				dataType: 'json',
				contentType : 'application/json; charset=utf-8',
				cache: false,
				error: (error) => {
					console.log(error);

					if (error && error.status === 403) {
						return;	
					}
				}
	    	});
		};

		Ember.RSVP.on('error', (error) => {
			if(error && error.errors && error.errors[0].status == "403") {
				this.get("auth").set("user", {});
				this.transitionTo("signin");

				Ember.$(".modal").modal("hide");
				//$('body').removeClass('modal-open');
				//$('.modal-backdrop').remove();
				return;
			}

		});

		Ember.$("body").on("keypress", "input", function(e) {
			if (e.key === "^") {
				e.preventDefault();
			}
		});


		this.notifications.setDefaultAutoClear(true);
		this.notifications.setDefaultClearNotification(1500);
	},


});
