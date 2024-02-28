import axios from 'axios';

const API_URL = "http://localhost:8080/api";

class Service {
    getPoll() {
        return axios.get(API_URL + "/get-poll")
    }

    postVote(vote) {
        return axios.post(API_URL + `/post-vote/${vote}`);
    }

    getVotes(pollId) {
        return axios.get(API_URL + `/get-votes/${pollId}`)
    }
}

export default new Service();