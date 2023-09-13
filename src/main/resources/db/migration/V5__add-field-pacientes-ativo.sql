ALTER TABLE pacientes ADD COLUMN ativo boolean;
UPDATE pacientes SET ativo = true;
