import { moduleForComponent, test } from 'ember-qunit';
import hbs from 'htmlbars-inline-precompile';

moduleForComponent('confirm-delete-modal', 'Integration | Component | confirm delete modal', {
  integration: true
});

test('it renders', function(assert) {
  // Set any properties with this.set('myProperty', 'value');
  // Handle any actions with this.on('myAction', function(val) { ... });

  this.render(hbs`{{confirm-delete-modal}}`);

  assert.equal(this.$().text().trim(), '');

  // Template block usage:
  this.render(hbs`
    {{#confirm-delete-modal}}
      template block text
    {{/confirm-delete-modal}}
  `);

  assert.equal(this.$().text().trim(), 'template block text');
});
