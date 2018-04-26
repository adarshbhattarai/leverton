import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';


import renderer from 'react-test-renderer';

it('renders without crashing', () => {
  const rendered = renderer.create(<App />).toJSON();
  expect(rendered).toBeTruthy();
});


/*
/
export default class App extends React.component {
    render() {
        return(
            <div>
              Hello World
            </div>
        )
    }
};
ReactDOM.render(<App />, document.getElementById("root"))*/
