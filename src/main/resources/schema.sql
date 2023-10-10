CREATE TABLE IF NOT EXISTS Products (
    pNumber INT AUTO_INCREMENT PRIMARY KEY,
    pName VARCHAR(255),
    pOwner VARCHAR(255),
    pDevelopers VARCHAR(255),
    scrumMaster VARCHAR(255),
    startDate DATE,
    pMethodology VARCHAR(255),
    githubLink VARCHAR(255)
);
