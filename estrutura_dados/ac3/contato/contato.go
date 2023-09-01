package contato

type Contato struct {
	Nome  string
	Email string
}

func (c *Contato) AlteraEmail(email string) {
	c.Email = email
}

