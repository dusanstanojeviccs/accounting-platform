import DS from 'ember-data';

export default DS.Model.extend({
	userId: DS.attr("number", {defaultValue: 0}),
	deleted: DS.attr("boolean", {defaultValue: false}),
	
	type: DS.attr("string", {defaultValue: "PAYABLE"}),

	accountNum: DS.attr("string", {defaultValue: ""}),
	accountName: DS.attr("string", {defaultValue: ""}),
});
