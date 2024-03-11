import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import logo from './Images/logo.png';
import React from 'react';
import Service from './Service';
import { Link } from 'react-router-dom';

class VotingPage extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            question: "",
            options: [],
            vote: 0,
            warning: false
        }
    }

    componentDidMount() {
        Service.getPoll(1).then(response => {
            this.setState(
                {
                    question: response.data.question,
                    options: response.data.options
                }
            )
        });
    }

    submit = () => {
        const vote = this.state;
        if (vote.vote === 0) {
            this.setState(
                {
                    warning: true
                }
            );
        } else {
            Service.postVote(1, vote.vote).then(response => {
                console.log("Vote: " + response.data);
            });
        }
    }

    render() {
        const {options, question, vote, warning} = this.state;
        return (
            <div className='app'>
                <img id='logo' src={logo} alt="Dizplai Logo"/>
                <h1 className='heading'>{question}</h1>
                {options.map(option => <div>
                    <button className={vote === option.optionId ? 'selected vote button' : 'not-selected vote button'} onClick={() => this.setState({vote: option.optionId})}>{option.optionText}</button>
                    </div>)}
                {vote === 0 ? (<button className='submit button' onClick={this.submit}>SUBMIT</button>) : (<Link to="/confirmation" onClick={this.submit}><button className='submit button'>SUBMIT</button></Link>)}
                <p className='warning' hidden={warning ? false : true}>You must select an option before submitting.</p>
            </div>
        );
    }
}

export default VotingPage;

// <button className='submit button' onClick={this.submit}>SUBMIT</button>
// <Link to="/confirmation" onClick={this.submit}><button className='submit button'>SUBMIT</button></Link>