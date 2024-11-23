// script.js

// Fonction pour obtenir tous les chercheurs
async function fetchChercheurs() {
    const response = await fetch('http://localhost:8085/api/chercheurs');
    const chercheurs = await response.json();
    const tableBody = document.querySelector('#chercheursTable tbody');
    tableBody.innerHTML = ''; // Réinitialiser le tableau

    chercheurs.forEach(chercheur => {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${chercheur.chno}</td>
            <td>${chercheur.chnom}</td>
            <td>${chercheur.grade}</td>
            <td>${chercheur.statut}</td>
            <td>${chercheur.email}</td>
            <td>
                <button onclick="fetchPublications(${chercheur.chno})">Voir Publications</button>
                <button onclick="deleteChercheur(${chercheur.chno})">Supprimer</button>
            </td>
        `;
        tableBody.appendChild(row);
    });
}

// Ajouter un chercheur
document.getElementById('chercheurForm').addEventListener('submit', async function(e) {
    e.preventDefault();
    const chercheur = {
        chno: document.getElementById('chno').value,
        chnom: document.getElementById('chnom').value,
        email: document.getElementById('email').value,
        grade: document.getElementById('grade').value,
        statut: document.getElementById('statut').value,
        facno: document.getElementById('facno').value,
        labno: document.getElementById('labno').value
    };

    const response = await fetch('http://localhost:8085/api/chercheurs', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(chercheur)
    });

    if (response.ok) {
        alert('Chercheur ajouté avec succès');
        fetchChercheurs();
    } else {
        alert('Erreur lors de l\'ajout');
    }
});

// Supprimer un chercheur
async function deleteChercheur(chno) {
    const response = await fetch(`http://localhost:8085/api/chercheurs/${chno}`, {
        method: 'DELETE',
    });

    if (response.ok) {
        alert('Chercheur supprimé');
        fetchChercheurs();
    } else {
        alert('Erreur lors de la suppression');
    }
}

// Obtenir les publications d'un chercheur
async function fetchPublications(chno) {
    try {
        const response = await fetch(`http://localhost:8085/api/chercheurs/${chno}/publications`);
        if (!response.ok) {
            throw new Error('Erreur lors de la récupération des publications');
        }
        const publications = await response.json();
        console.log(publications); // Ajoutez ce log pour voir la réponse dans la console
        const tableBody = document.querySelector('#publicationsTable tbody');
        tableBody.innerHTML = '';

        publications.forEach(pub => {
            const publication = pub.publication; // Accéder à l'objet publication imbriqué

            if (!publication) {
                console.error("La publication est absente pour cet enregistrement :", pub);
                return; // Passer à la prochaine itération si la publication est absente
            }

            const row = document.createElement('tr');
            row.innerHTML = `
                <td>${publication.pubno || 'Numéro non disponible'}</td>
                <td>${publication.titre || 'Titre non disponible'}</td>
                <td>${publication.theme || 'Thème non disponible'}</td>
                <td>${publication.editeur || 'Éditeur non disponible'}</td>
                <td>${publication.date ? new Date(publication.date).toLocaleDateString() : 'Date non disponible'}</td>
                <td>${publication.apparition || 'Apparition non disponible'}</td>
            `;
            tableBody.appendChild(row);
        });
    } catch (error) {
        console.error(error);
        alert('Une erreur est survenue lors de la récupération des publications');
    }
}

// Obtenir les chercheurs dans un laboratoire
async function getResearchersInLaboratory() {
    const labno = document.getElementById('labnoSearch').value;
    const response = await fetch(`http://localhost:8085/api/chercheurs/lab/${labno}`);
    const chercheurs = await response.json();
    const tableBody = document.querySelector('#chercheursLabTable tbody');
    tableBody.innerHTML = '';

    chercheurs.forEach(chercheur => {
        console.log('Publications reçues:', publications);

        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${chercheur.chno}</td>
            <td>${chercheur.chnom}</td>
        `;
        tableBody.appendChild(row);
    });
}

// Charger les chercheurs au démarrage
fetchChercheurs();
