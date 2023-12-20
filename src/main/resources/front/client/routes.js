const React = require('react')
const {
  Router,
  Route,
  IndexRoute,
  browserHistory
} = require('react-router')
const App = require('componets/app/app.js')
const Movies = require('componets/movies/movies.js')
const Movie = require('componets/movie/movie.js')

module.exports = (
  <Router history={browserHistory}>
    <Router path="/" component={App}>
      <IndexRoute component={Movies}></IndexRoute>
      <Route path="movies" component={Movies}>
        <Route path=":id" component={Movie}></Route>
      </Route>
    </Router>
  </Router>
)