import Ember from 'ember';
import config from './config/environment';

const Router = Ember.Router.extend({
  location: config.locationType
});

Router.map(function() {
  this.route('accounting', function() {
    this.route('invoice', {path: '/invoice/:id'});
    this.route('bill', {path: '/bill/:id'});
    this.route('dashboard');
    this.route('bills');
    this.route('accounts');
    this.route('invoices');
    this.route('vendors');
  });

  this.route('signin');
  this.route('signup');

  this.route('buyer', function() {
    this.route('books', function() {
      this.route('reports', function() {});
    });
  });
});

export default Router;
