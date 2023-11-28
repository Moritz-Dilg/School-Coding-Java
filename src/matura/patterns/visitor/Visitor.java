package matura.patterns.visitor;

interface VisitorAcceptor {
    int accept(Visitor visitor);
}

interface Visitor {
    int visit(Node node);
}

