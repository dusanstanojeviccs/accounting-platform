import DS from 'ember-data';

export default DS.Transform.extend({
  deserialize(serialized) {
    return moment(serialized).format("DD/MM/YYYY");
  },

  serialize(deserialized) {
    return moment(deserialized, "DD/MM/YYYY");
  }
});
