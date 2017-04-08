import DS from 'ember-data';

export default DS.Model.extend({
	userId: DS.attr("number", {defaultValue: 0}),
	deleted: DS.attr("boolean", {defaultValue: false}),

    vendorName: DS.attr("string", {defaultValue: ""}),
    payeeName: DS.attr("string", {defaultValue: ""}),
    payeeEmail: DS.attr("string", {defaultValue: ""}),
    phoneNumber: DS.attr("string", {defaultValue: ""})
});
