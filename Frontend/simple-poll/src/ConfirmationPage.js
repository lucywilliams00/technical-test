import React from 'react';
import Service from './Service';
import logo from './Images/logo.png';

class ConfirmationPage extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            totalVotes: 0,
            results: []
        }
    }

    componentDidMount() {
        const pollId = 1;
        Service.getVotes(pollId).then(response => {
            this.setState(
                {
                    totalVotes: response.data.totalVotes,
                    results: response.data.results.sort((a, b) => (a.votes <= b.votes) ? 1 : -1)
                }
            )
        });
    }

    render() {
        const {totalVotes, results} = this.state;
        return (
            <div className='app'>
                <img id='logo' src={logo} alt="Dizplai Logo"/>
                <h1 className='heading'>Thank you for your response!</h1>
                {results.map(result => <div className='inline'>
                    <p className='result'>{result.optionText} {Math.round((result.votes/totalVotes)*100)}%</p>
                    </div>)}
            </div>
        );
    }
}

export default ConfirmationPage;
