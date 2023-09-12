ALTER TABLE medicos ADD COLUMN ativo boolean;
UPDATE medicos SET ativo = true;
