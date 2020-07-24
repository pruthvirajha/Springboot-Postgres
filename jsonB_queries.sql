select  * from person;

--Add key value to existing json document
update person set address = address || '{"country": "Canada"}' where id =1;

--remove key value from existing json document
update person set address = address - 'country' where id =1;

--Querying nested values in a json document
select address->'city',address->'street',address->'pincodes' from person where address->'city' ? 'Bengaluru';

-- Find documents in which the key "houseNo" has value "13B"
SELECT address->'street', address->'pincodes' FROM person WHERE address @> '{"houseNo":"13B"}';

-- Find documents in which the key "houseNo" is present
SELECT address->'street', address->'pincodes' FROM person WHERE address ? 'houseNo';

SELECT address->'street', address->>'pincodes' AS PINCODES  FROM person WHERE address->'pincodes'  ? '577203';

SELECT address->'phoneNumbers'->'mobileNumber'  from person where id =3;

select * from person where address->'phoneNumbers'->'mobileNumber' ? '9893434934'

-- jsonb_ops indexing
CREATE INDEX i_city ON person USING GIN ((address -> 'city'));
SELECT address->'city', address->'phoneNumbers' FROM person where address->'city' ? 'California';

-- jsonb_path_ops indexing
CREATE INDEX i_city2 ON person USING GIN ((address) jsonb_path_ops);

SELECT address->'city', address->'phoneNumbers' FROM person where address @@ '$.city == "California"';

SELECT address->'city', address->'phoneNumbers' FROM person where address @@ '$.phoneNumbers.mobileNumber == "phone100"';
