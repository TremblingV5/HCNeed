from crawler.utils.snowflake import SnowflakeField, SnowflakeIDGenerator
from tortoise.models import Model
from tortoise import fields


class Base(Model):
    id = SnowflakeField(pk=True, generated=False)
    created_at = fields.DatetimeField(auto_now_add=True)

    @classmethod
    async def create(cls, **kwargs):
        kwargs["id"] = await SnowflakeIDGenerator(cls).generate_id()
        return await super().create(**kwargs)

    class Meta:
        abstract = True
