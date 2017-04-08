import DS from 'ember-data';

export default DS.Transform.extend({
  deserialize(serialized) {
    return (serialized / 100).toFixed(2);
  },

  serialize(deserialized) {
    return deserialized * 100;
  }
});
