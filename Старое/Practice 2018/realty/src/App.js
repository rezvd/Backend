import React, { Component } from 'react';
//import logo from './logo.svg';
import './App.css';

class App extends Component {
  render() {
    return (
      <div className="App">
        <header className="App-header">
          <h1 className="App-title">Вид: квартира</h1>
        </header>
        <div className="Ads">
            <div className="Ad">
                <div className="Ad__title">Количество комнат:</div>
                <div className="Ad__rooms">
                    <span className="Button">1k</span>
                    <span className="Button">2k</span>
                    <span className="Button">3k</span>
                    <span className="Button">4k</span>
                    <span className="Button">5k</span>
                    <span className="Button">6+k</span>
                </div>
            </div>
            <div className="Ad__floors">
                <div className="Ad__title">Этаж / этажность:</div>
                <input className="Floor"/>
                <span>/</span>
                <input className="Floor"/>
            </div>
            <div className="Ad__type">
                <div className="Ad__title">Тип дома:</div>
                <span className="Button">Панельный</span>
                <span className="Button">Монолитный</span>
                <span className="Button">Кирпичный</span>
            </div>
        </div>
      </div>
    );
  }
}

export default App;
