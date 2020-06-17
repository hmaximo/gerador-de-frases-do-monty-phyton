package challenge;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuoteServiceImpl implements QuoteService {

	@Autowired
	private QuoteRepository repository;

	@Override
	public Quote getQuote() {
		Random rand = new Random();
		int currentNumberOfQuotes = (int) this.repository.count();
		return this.repository.findById(Integer.valueOf(rand.nextInt(currentNumberOfQuotes))).get();
	}

	@Override
	public Quote getQuoteByActor(String actor) {
		List<Quote> actorQuotes = this.repository.findByActor(actor);
		Random rand = new Random();
		return actorQuotes.get(rand.nextInt(actorQuotes.size()));
	}

}
